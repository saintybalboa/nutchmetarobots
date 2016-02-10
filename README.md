# Apache Nutch 2.3 - Meta Robots - Plugin
A plugin developed for Apache Nutch 2.3 to honour the robots meta tag at index time. Apache Nutch 2.3 currenlty ignores the ``noindex`` rule and proceeds to index the content to Solr. This plugin has been developed to discard the document from index if it contains the robots metatag with the associated ``noindex`` rule.

##Usage

Include the ``metarobots`` plugin first in the ``plugin.includes`` property.

```
<property>
    <name>plugin.includes</name>
    <value>metarobots|indexer-solr|scoring-opic|urlnormalizer-(pass|regex|basic)|protocol-(http|https)|urlfilter-regex|parse-(html|metatags|tika)|index-(basic|metadata|more)</value>
</property>
```

##How To Build

Before proceeding make sure you have ``apache ant`` installed. 

In order to use this plugin you'll need to build it into Apache Nutch 2.3.

Follow these steps to ensure your plugin gets built into the runtime folder:

1. Copy the plugin files to the ``NUTCH_ROOT/src/plugin`` folder. 

2. Open ``NUTCH_ROOT/src/plugin/build.xml`` and add the following children to the associated target elements:  
    ```
        <target name="deploy">
            <ant dir="metarobots" target="deploy"/>
        </target>
        
        <target name="test">
            <ant dir="metarobots" target="test"/>
        </target>
        
        <target name="clean">
            <ant dir="metarobots" target="clean"/>
        </target>
    ```

    **Do NOT overwrite any existing ```<ant>``` elements**
    
3. Open a terminal and navigate to the ``NUTCH_ROOT`` directory.

   Enter the following command:
   
   ```ant runtime```
   




##Running Tests
To test the plugin, open a terminal and navigate to the ``NUTCH_ROOT/runtime/local`` directory. 

Run the following command:

```
 sudo bin/nutch indexchecker http://domain.com/metatag-robots-noindex-rule
```
Ensure the webpage under test contains the robots metatag with the associated ``noindex`` rule. Nutch will return ``Document discarded`` in the terminal.