/**
 * "First, solve the problem. Then, write the code. -John Johnson"
 * "Or use Vangav M"
 * www.vangav.com
 * */

/**
 * MIT License
 *
 * Copyright (c) 2016 Vangav
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 * */

/**
 * Community
 * Facebook Group: Vangav Open Source - Backend
 *   fb.com/groups/575834775932682/
 * Facebook Page: Vangav
 *   fb.com/vangav.f
 * 
 * Third party communities for Vangav Backend
 *   - play framework
 *   - cassandra
 *   - datastax
 *   
 * Tag your question online (e.g.: stack overflow, etc ...) with
 *   #vangav_backend
 *   to easier find questions/answers online
 * */

package com.vangav.backend.networks.rest_client;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author mustapha
 * fb.com/mustapha.abdallah
 */
public abstract class RestRequest {

  @JsonIgnore
  private Map<String, String> headers = new HashMap<String, String>();
  
  /**
   * hasHeaders
   * @return true if this RestRequest Object has specific headers and false
   *           otherwise
   * @throws Exception
   */
  @JsonIgnore
  public boolean hasHeaders () throws Exception {
    
    if (this.headers.isEmpty() == true) {
      
      return false;
    }
    
    return true;
  }
  
  /**
   * addHeader
   * @param key
   * @param value
   * @throws Exception
   */
  @JsonIgnore
  public void addHeader (String key, String value) throws Exception {
    
    this.headers.put(key, value);
  }
  
  /**
   * addHeaders
   * @param headers
   * @throws Exception
   */
  @JsonIgnore
  public void addHeaders (Map<String, String> headers) throws Exception {
    
    this.headers.putAll(headers);
  }
  
  /**
   * getHeaders
   * @return this RestRequest Object's specific headers
   * @throws Exception
   */
  @JsonIgnore
  public Map<String, String> getHeaders () throws Exception {
    
    return this.headers;
  }
}