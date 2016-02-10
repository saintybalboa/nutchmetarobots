package saintybalboa.nutch.meta;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

import org.mortbay.log.Log;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.oro.text.regex.*;
import org.apache.nutch.util.NutchConfiguration;
import org.apache.nutch.util.URLUtil;
import org.apache.nutch.util.domain.DomainSuffix;

import org.apache.avro.util.Utf8;
import org.apache.hadoop.conf.Configuration;
import org.apache.nutch.indexer.IndexingException;
import org.apache.nutch.indexer.IndexingFilter;
import org.apache.nutch.indexer.NutchDocument;
import org.apache.nutch.storage.WebPage;

//Commons Logging imports
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MetaRobotsIndexer implements IndexingFilter {
	
	public static final Logger LOG = LoggerFactory.getLogger(MetaRobotsIndexer.class);
	
    private Configuration conf;
    
    private Collection<WebPage.Field> fields = new HashSet<WebPage.Field>();

    
    
    @Override
    public NutchDocument filter(NutchDocument document, String url, WebPage webPage) throws IndexingException {
    	
		 String meta_robots = document.getFieldValue("meta_robots");
		 
         return (meta_robots != null && meta_robots.toString().toLowerCase().contains("noindex")) ? null : document;
    }

 

    @Override
    public void setConf(Configuration conf) {
        this.conf = conf;
    }

    @Override
    public Configuration getConf() {
        return this.conf;
    }

    @Override
    public Collection<WebPage.Field> getFields() {
        return new HashSet<WebPage.Field>();
    }
    
    
    
    public static void main(String[] args) throws Exception {

    }
}
