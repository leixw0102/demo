/* Copyright 2013 Future TV, Inc.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package com.ehl.demo.redis;


import com.ehl.demo.redis.exception.CacheExecption;
import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * User: xiaowu lei
 * Date: 13-11-15
 * Time: 下午1:26
 */
public interface IRedisCache <T> {
      public T callBack(Jedis jedis)throws CacheExecption;
}