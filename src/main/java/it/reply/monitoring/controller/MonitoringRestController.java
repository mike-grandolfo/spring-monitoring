/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.reply.monitoring.controller;

import it.reply.monitoring.data.MemberDao;
import it.reply.monitoring.model.Member;
import it.reply.monitoring.service.Adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/")
public class MonitoringRestController {
	@Autowired
	private MemberDao memberDao;

	@Autowired
	private Adapter adapter;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Member> listAllMembers() {
		return memberDao.findAllOrderedByName();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Member lookupMemberById(@PathVariable("id") Long id) {
		return memberDao.findById(id);
	}

	@RequestMapping(value = "/debug", method = RequestMethod.GET)
	public @ResponseBody String getMonitoringInfoDebug() {
		return "OCP_PROD_CORE";
	}

	@RequestMapping(value = "/adapters", method = RequestMethod.GET)
	public @ResponseBody List<String> getAdapters() throws Exception {
		List<String> response = adapter.getAllAdapters();
		return response;
	}
}
