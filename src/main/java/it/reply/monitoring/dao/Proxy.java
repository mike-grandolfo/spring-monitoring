package it.reply.monitoring.dao;

/**
 * Proxy generated by hbm2java
 */
public class Proxy implements java.io.Serializable {

	private Integer proxyId;
	private String name;
	private String nameTemplate;

	public Proxy() {
	}

	public Proxy(String name, String nameTemplate) {
		this.name = name;
		this.nameTemplate = nameTemplate;
	}

	public Integer getProxyId() {
		return this.proxyId;
	}

	public void setProxyId(Integer proxyId) {
		this.proxyId = proxyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameTemplate() {
		return this.nameTemplate;
	}

	public void setNameTemplate(String nameTemplate) {
		this.nameTemplate = nameTemplate;
	}

}
