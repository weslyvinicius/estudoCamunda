/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.itau.journey.simple;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.execute;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.historyService;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.jobQuery;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.runtimeService;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.taskService;
import static org.camunda.bpm.extension.mockito.DelegateExpressions.autoMock;
import static org.mockito.Mockito.mock;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import br.com.itau.journey.service.Showcase;
import org.camunda.bpm.engine.runtime.Job;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;

import java.util.List;

/*@Deployment(resources = "bpmn/sample.bpmn")*/
public class ShowcaseTest/* extends AbstractProcessEngineRuleTest*/ {

  private Showcase showcase;

  /*@Before*/
  public void setUp() {
    autoMock("bpmn/sample.bpmn");

    showcase = new Showcase();
    setField(showcase, "runtimeService", runtimeService());
    setField(showcase, "taskService", taskService());
  }

  /*@Test*/
  public void startAndFinishProcess() {
    showcase.notify(mock(PostDeployEvent.class));
    final String processInstanceId = showcase.getProcessInstanceId();

    List<Job> list = jobQuery().active().processInstanceId(processInstanceId).list();

    execute(list.get(0));

    list = jobQuery().active().processInstanceId(processInstanceId).list();

    execute(list.get(0));

    assertThat(historyService().createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getEndTime()).isNotNull();
  }

}
