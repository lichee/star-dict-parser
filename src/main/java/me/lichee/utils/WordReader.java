package me.lichee.utils;

import java.util.ArrayList;
import java.util.List;

import me.lichee.bean.JpMean;
import me.lichee.bean.JpWord;

public class WordReader {
	
	public static JpWord parse(String desc,String hanzi){
		if(desc==null) return null;
		JpWord word = new JpWord();
		String[] arr = desc.split("\n");
		word.setHanzi(hanzi);
		if(arr[0]!=null){
			String[] luomaAndJiaming = arr[0].split(" ");
			if(luomaAndJiaming.length>1){
				word.setJiaming(luomaAndJiaming[1]);
				word.setLuoma(luomaAndJiaming[0]);
			}else{
				word.setJiaming(hanzi);
				word.setLuoma(luomaAndJiaming[0]);
			}
		}
		List<JpMean> means = new ArrayList<JpMean>();
		if(arr[1]!=null){
			//如果有多条释义。。
			if(arr[1].startsWith("（1）")){
				int sort = 1;//释义的
				JpMean tmpMean = null;
				//遍历每一行
				for(int n=1;n<arr.length;n++){
					if(arr[n].startsWith("（"+sort+"）")){
						if(tmpMean!=null){
							JpMean tmp1 = new JpMean();
							tmp1.setMean(tmpMean.getMean());
							tmp1.setSort(tmpMean.getSort());
							means.add(tmp1);
							tmpMean = new JpMean();
							tmpMean.setMean(arr[n]);
							tmpMean.setSort(sort);
						}else{
							tmpMean = new JpMean();
							tmpMean.setMean(arr[n]);
							tmpMean.setSort(sort);
						}
						sort = sort+1;
					}else{
						tmpMean.setMean(tmpMean.getMean()+arr[n]);
					};
				}
				//加上最后一条
				/*JpMean e = new JpMean();
				e.setMean(tmp.toString());
				e.setSort(sort);*/
				JpMean tmp2 = tmpMean;
				tmp2.setMean(tmpMean.getMean());
				tmp2.setSort(tmpMean.getSort());
				means.add(tmp2);
				
			}
			//如果是单条释义
			else{
				JpMean mean = new JpMean();
				mean.setMean(reBuildString(arr,1));
				mean.setSort(1);
				means.add(mean);
			}
		}
		word.setMeans(means);
		return word;
	}
	
	/**
	 * 截取掉数组arr前i个元素，把后面的都拼成一个字符串
	 * @param arr
	 * @param i
	 * @return
	 */
	private static String reBuildString(String[] arr,int i){
		String str = "";
		for(int x = i;i<arr.length;i++){
			str += arr[x];
		}
		return str;
	}
	
	public static void main(String[] args){
		System.out.println("（2）〔心の状態〕".startsWith("（"+2+"）"));
	}
}
