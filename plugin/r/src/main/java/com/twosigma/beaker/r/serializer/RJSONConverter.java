/*
 *  Copyright 2015 TWO SIGMA OPEN SOURCE, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.twosigma.beaker.r.serializer;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REXPReference;

import java.io.IOException;

public class RJSONConverter {
  public static String toJSON(REXPReference rexp) {
    ObjectMapper mapper = new ObjectMapper();
    String result = "";
    try {
      if (rexp.isInteger()) {
        result = mapper.writeValueAsString(rexp.asInteger());
      } else if (rexp.isString()) {
        result = mapper.writeValueAsString(rexp.asString());
      }
    } catch (REXPMismatchException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      return result;
    }
  }
}