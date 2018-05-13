/**
 * Copyright 2012 Sven Diedrichsen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package de.jollyday.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.InputStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class XMLUtilTest {

	@Mock
	InputStream inputStream;

	@InjectMocks
	XMLUtil xmlUtil = new XMLUtil();

	@Test(expected = IllegalArgumentException.class)
	public void testUnmarshallConfigurationNullCheck() throws Exception {
		xmlUtil.loadUnmarshaller().unmarshallConfiguration(null);
	}

	@Test(expected = IllegalStateException.class)
	public void testUnmarshallConfigurationException() throws Exception {
		xmlUtil.loadUnmarshaller().unmarshallConfiguration(inputStream);
		verify(inputStream).close();
	}

}
