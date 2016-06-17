package it.reply.monitoring.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Adapter implements Serializable {

	// ZABBIX("zabbix"), NAGIOS("nagios");

	// private String NAGIOS = "nagios";
	// private String ZABBIX = "zabbix";
	//
	// List<String> adapters = new
	//
	// private static final long serialVersionUID = 6559999818418491070L;
	//
	// private String adapter;
	//
	// private Adapter(String adapter) {
	// this.adapter = adapter;
	// }
	//
	// public String getAdapter() {
	// return adapter;
	// }
	//
	// public void setAdapter(String adapter) {
	// this.adapter = adapter;
	// }
	//
	// public static Adapter findByName(String name) {
	// for (Adapter a : values()) {
	// if (a.getAdapter().equals(name)) {
	// return a;
	// }
	// }
	// throw new IllegalArgumentException("Cannot find [" + name + "] for " +
	// Adapter.class.getCanonicalName());
	// }
	//
	// @Bean
	// public List<String> getAllAdapter() {
	// List<String> adapters = new ArrayList<String>();
	// for (Adapter a : values()) {
	// adapters.add(a.getAdapter());
	// }
	// return adapters;
	// }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String NAGIOS = "nagios";
	public String ZABBIX = "zabbix";

	@Bean
	public List<String> getAllAdapters() {

		List<String> adapters = new ArrayList<String>();
		adapters.add(this.ZABBIX);
		adapters.add(this.NAGIOS);
		return adapters;
	}

}
