package org.yage.dict;

import java.util.List;
import java.util.Map;

import jdk.nashorn.internal.runtime.JSONFunctions;
import me.lichee.bean.JpWord;
import me.lichee.utils.MysqlUtil;
import me.lichee.utils.WordReader;

import org.yage.dict.star.StarDictParser;
import org.yage.dict.star.WordPosition;

import com.alibaba.fastjson.JSON;

/**
 * This is not a runnable app, refer package org.yage.dict.star please!
 */
public class App{
    public static void main(String[] args) throws Exception{
    	//testCj();
    	//System.out.println("----------------------------------------");
    	testJc();
    }
    
    public static void testCj(){
    	String indexFile = "D:\\dev\\DrEye-cj.idx";
    	String dictFile = "D:\\dev\\Dr.eye-CJ.pdb.tab.utf.dict";
    	StarDictParser p = new StarDictParser();
    	p.loadContentFile(dictFile);
    	p.loadIndexFile(indexFile);
    	List<Map.Entry<String,WordPosition>> list = p.searchWord("意思");
    	for(Map.Entry<String,WordPosition> e : list){
    		System.out.println("***********");
    		String key = e.getKey();
    		WordPosition value = e.getValue();
    		String desc = p.getWordExplanation(value.getStartPos(), value.getLength());
    		System.out.println(key);
    		System.out.println(desc);
    		
    	}
    }
    
    public static void testJc() throws Exception{
    	String indexFile = "D:\\dev\\XiaoXueTang-jc.idx";
    	String dictFile = "D:\\dev\\XiaoXueTang-jc.dict";
    	StarDictParser p = new StarDictParser();
    	p.loadContentFile(dictFile);
    	p.loadIndexFile(indexFile);
    	/*List<Map.Entry<String,WordPosition>> list = p.searchWord("気味");
    	for(Map.Entry<String,WordPosition> e : list){
    		String key = e.getKey();
    		WordPosition value = e.getValue();
    		String desc = p.getWordExplanation(value.getStartPos(), value.getLength());
    		System.out.println(key);
    		System.out.println(desc);
    		JpWord word = WordReader.parse(desc,key);
    		MysqlUtil.saveWords(word);
    		System.out.println(JSON.toJSONString(word));
    		System.out.println(p.getWords().keySet().size());
    	}*/
    }
}
