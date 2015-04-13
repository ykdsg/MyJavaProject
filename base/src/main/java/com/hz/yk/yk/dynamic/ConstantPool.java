package com.hz.yk.yk.dynamic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author yangke
 *         Date: 12-8-3
 *         Time: ÏÂÎç3:53
 */
public class ConstantPool {

    private List<Entry> pool = new ArrayList<Entry>(32);
    private Map<Object, Short> map = new HashMap<Object, Short>(16);
    private boolean readOnly = false;

    public short getUtf8(String paramString) {
        if (paramString == null)
            throw new NullPointerException();
        return getValue(paramString);
    }

    public short getInteger(int paramInt) {
        return getValue(new Integer(paramInt));
    }

    public short getFloat(float paramFloat) {
        return getValue(new Float(paramFloat));
    }

    public short getClass(String paramString) {
        short s = getUtf8(paramString);
        return getIndirect(new IndirectEntry(7, s));
    }

    public short getString(String paramString) {
        short s = getUtf8(paramString);
        return getIndirect(new IndirectEntry(8, s));
    }

    public short getFieldRef(String paramString1, String paramString2, String paramString3) {
        short s1 = getClass(paramString1);
        short s2 = getNameAndType(paramString2, paramString3);
        return getIndirect(new IndirectEntry(9, s1, s2));
    }

    public short getMethodRef(String paramString1, String paramString2, String paramString3) {
        short s1 = getClass(paramString1);
        short s2 = getNameAndType(paramString2, paramString3);
        return getIndirect(new IndirectEntry(10, s1, s2));
    }

    public short getInterfaceMethodRef(String paramString1, String paramString2, String paramString3) {
        short s1 = getClass(paramString1);
        short s2 = getNameAndType(paramString2, paramString3);
        return getIndirect(new IndirectEntry(11, s1, s2));
    }

    public short getNameAndType(String paramString1, String paramString2) {
        short s1 = getUtf8(paramString1);
        short s2 = getUtf8(paramString2);
        return getIndirect(new IndirectEntry(12, s1, s2));
    }

    public void setReadOnly() {
        this.readOnly = true;
    }

    public void write(OutputStream paramOutputStream) throws IOException {
        DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
        localDataOutputStream.writeShort(this.pool.size() + 1);
        Iterator<Entry> localIterator = this.pool.iterator();
        while (localIterator.hasNext()) {
            Entry localEntry = (Entry) localIterator.next();
            localEntry.write(localDataOutputStream);
        }
    }

    private short addEntry(Entry paramEntry) {
        this.pool.add(paramEntry);
        if (this.pool.size() >= 65535)
            throw new IllegalArgumentException("constant pool size limit exceeded");
        return (short) this.pool.size();
    }

    private short getValue(Object paramObject) {
        Short localShort = (Short) this.map.get(paramObject);
        if (localShort != null)
            return localShort.shortValue();
        if (this.readOnly)
            throw new InternalError("late constant pool addition: " + paramObject);
        short s = addEntry(new ValueEntry(paramObject));
        this.map.put(paramObject, new Short(s));
        return s;
    }

    private short getIndirect(IndirectEntry paramIndirectEntry) {
        Short localShort = (Short) this.map.get(paramIndirectEntry);
        if (localShort != null)
            return localShort.shortValue();
        if (this.readOnly)
            throw new InternalError("late constant pool addition");
        short s = addEntry(paramIndirectEntry);
        this.map.put(paramIndirectEntry, new Short(s));
        return s;
    }

    private static abstract class Entry {
        public abstract void write(DataOutputStream paramDataOutputStream) throws IOException;
    }

    private static class IndirectEntry extends ConstantPool.Entry {
        private int tag;
        private short index0;
        private short index1;

        public IndirectEntry(int paramInt, short paramShort) {
            super();
            this.tag = paramInt;
            this.index0 = paramShort;
            this.index1 = 0;
        }

        public IndirectEntry(int paramInt, short paramShort1, short paramShort2) {
            super();
            this.tag = paramInt;
            this.index0 = paramShort1;
            this.index1 = paramShort2;
        }

        public void write(DataOutputStream paramDataOutputStream) throws IOException {
            paramDataOutputStream.writeByte(this.tag);
            paramDataOutputStream.writeShort(this.index0);
            if ((this.tag != 9) && (this.tag != 10) && (this.tag != 11) && (this.tag != 12))
                return;
            paramDataOutputStream.writeShort(this.index1);
        }

        public int hashCode() {
            return (this.tag + this.index0 + this.index1);
        }

        public boolean equals(Object paramObject) {
            if (paramObject instanceof IndirectEntry) {
                IndirectEntry localIndirectEntry = (IndirectEntry) paramObject;
                if ((this.tag == localIndirectEntry.tag) && (this.index0 == localIndirectEntry.index0) && (this.index1 == localIndirectEntry.index1))
                    return true;
            }
            return false;
        }

    }

    private static class ValueEntry extends ConstantPool.Entry {
        private Object value;

        public ValueEntry(Object paramObject) {
            super();
            this.value = paramObject;
        }

        public void write(DataOutputStream paramDataOutputStream) throws IOException {
            if (this.value instanceof String) {
                paramDataOutputStream.writeByte(1);
                paramDataOutputStream.writeUTF((String) this.value);
            } else if (this.value instanceof Integer) {
                paramDataOutputStream.writeByte(3);
                paramDataOutputStream.writeInt(((Integer) this.value).intValue());
            } else if (this.value instanceof Float) {
                paramDataOutputStream.writeByte(4);
                paramDataOutputStream.writeFloat(((Float) this.value).floatValue());
            } else if (this.value instanceof Long) {
                paramDataOutputStream.writeByte(5);
                paramDataOutputStream.writeLong(((Long) this.value).longValue());
            } else if (this.value instanceof Double) {
                paramDataOutputStream.writeDouble(6.0D);
                paramDataOutputStream.writeDouble(((Double) this.value).doubleValue());
            } else {
                throw new InternalError("bogus value entry: " + this.value);
            }
        }
    }
}
