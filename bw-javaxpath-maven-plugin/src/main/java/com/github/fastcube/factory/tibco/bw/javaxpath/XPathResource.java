/**
 * (C) Copyright 2019-2020 Fastcube SAS
 * (http://www.fastcube.fr/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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
package io.github.fastcube.factory.tibco.bw.javaxpath;

/**
 * POJO class used for Maven configuration.
 * 
 * @author Emilien THOMAS
 * 
 */
public class XPathResource {

	/**
	 * Name of the resource, such as /Resources/Java/extension.javaxpath
	 */
	private String resourceName;

	/**
	 * Qualified name of the java class, such as java.lang.String.
	 */
	private String className;

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(final String resourceName) {
		this.resourceName = resourceName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(final String className) {
		this.className = className;
	}
}