package com.hz.yk.lucene;

import java.io.File;
import java.io.IOException;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wuzheng.yk
 *         Date: 13-1-21
 *         Time: 下午4:52
 */
public class WriteLcok {

    private Directory directory;
    private Analyzer analyzer;

    @Before
    public void  Init() throws IOException {
        directory = FSDirectory.open(new File("D://lucene/index"));
        analyzer = new SimpleAnalyzer(Version.LUCENE_40);
    }

    @Test
    public void TestWriteLock() throws IOException{
        IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_40, analyzer );
        IndexWriter writer1 = new  IndexWriter(directory, iwc);
        //writer1.close();
        IndexWriter writer2 = null;
        try{
            if(IndexWriter.isLocked(directory)){
                System.out.println("writer1已经被锁");
            }
            writer2 = new IndexWriter(directory, iwc);
            System.out.println("第二个IndexWriter打开成功！");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("第二个IndexWriter打开失败！");
        }finally{
            writer1.close();
        }
    }

}
