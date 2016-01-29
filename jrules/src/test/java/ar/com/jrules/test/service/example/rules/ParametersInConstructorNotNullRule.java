package ar.com.jrules.test.service.example.rules;

import java.util.List;

import ar.com.jrules.core.exception.JRuleException;
import ar.com.jrules.core.model.RuleResponse;
import ar.com.jrules.core.model.RuleState;
import ar.com.jrules.core.model.JRule;
import ar.com.jrules.core.model.JRuleEvaluateParameters;

/**
 * Copyright 2014 Joel del Valle <joelmarcosdelvalle@gmail.com>
 * 
 * This file is part of jrules, project of jrules.
 * 
 * jrules is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * jrules is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * jrules. If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 * @author joel.delvalle
 * 
 */
public class ParametersInConstructorNotNullRule extends JRule {

	@Override
	public int getRuleOrder() {
		return 0;
	}

	@Override
	public RuleResponse execute(JRuleEvaluateParameters jRuleEvaluateParameters) throws JRuleException {

		List<Object> parametersList = jRuleEvaluateParameters.getParametersInOrder();

		RuleResponse ruleResponse = new RuleResponse(RuleState.RULE_OK);
		for (Object object : parametersList) {
			if (object == null) {
				ruleResponse.setRuleState(RuleState.RULE_OK);
				ruleResponse.setMessage("los parametros no pueden ser null");
			}
		}

		return ruleResponse;

	}

}
