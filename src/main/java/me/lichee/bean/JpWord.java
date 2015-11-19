package me.lichee.bean;

import java.util.List;

public class JpWord {
	
	private int id;
	private String hanzi;
	private String luoma;
	private String jiaming;
	private String yinbiao;
	private String yindiao;
	private String audio;
	private String inserter;
	private List<JpMean> means;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLuoma() {
		return luoma;
	}
	public void setLuoma(String luoma) {
		this.luoma = luoma;
	}
	public String getJiaming() {
		return jiaming;
	}
	public void setJiaming(String jiaming) {
		this.jiaming = jiaming;
	}
	public String getYinbiao() {
		return yinbiao;
	}
	public void setYinbiao(String yinbiao) {
		this.yinbiao = yinbiao;
	}
	public String getYindiao() {
		return yindiao;
	}
	public void setYindiao(String yindiao) {
		this.yindiao = yindiao;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public String getInserter() {
		return inserter;
	}
	public void setInserter(String inserter) {
		this.inserter = inserter;
	}
	public List<JpMean> getMeans() {
		return means;
	}
	public void setMeans(List<JpMean> means) {
		this.means = means;
	}
	public String getHanzi() {
		return hanzi;
	}
	public void setHanzi(String hanzi) {
		this.hanzi = hanzi;
	}
	
}
