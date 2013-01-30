package com.hz.yk.lucene;

import java.io.File;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

/**
 * @author wuzheng.yk
 *         Date: 13-1-18
 *         Time: 下午5:06
 */
public class TxtFileIndexer {
    protected String[] ids={"1", "2"};

    protected String[] content={"Amsterdam has lost of add  cancals", "i love  add this girl"};

    protected String[] city={"Amsterdam", "Venice"};

    private Directory dir;

    /**
     * 初始添加文档
     * @throws Exception
     */
    @Test
    public void init() throws Exception {
        String pathFile="D://lucene/index";
        dir=FSDirectory.open(new File(pathFile));
        IndexWriter writer=getWriter();
        for(int i=0; i < ids.length; i++) {
            Document doc=new Document();
            doc.add(new StringField("id", ids[i], Field.Store.YES));
            doc.add(new TextField("content", content[i], Field.Store.YES));
            doc.add(new StringField("city", city[i], Field.Store.YES));
            writer.addDocument(doc);
        }
        System.out.println("init ok?");
        writer.close();
    }

    /**
     * 获得IndexWriter对象
     * @return
     * @throws Exception
     */
    public IndexWriter getWriter() throws Exception {
        Analyzer analyzer=new StandardAnalyzer(Version.LUCENE_40);
        IndexWriterConfig iwc=new IndexWriterConfig(Version.LUCENE_40, analyzer);
        return new IndexWriter(dir, iwc);
    }
}
