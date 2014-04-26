/*
 *  Copyright 2012-2014 Comcast Cable Communications Management, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.comcast.xfinity.sirius.api.impl

/**
 * Represents an event that must be ordered across the cluster, so probably a PUT or DELETE.
 * 
 * Only requests that do not commute must be ordered.  We're willing to do 'dirty reads' for 
 * commutative requests.
 * 
 * @param sequence Sequence number that totally orders this event across all events and nodes in the cluster.
 * @param timestamp Timestamp which indicates when the event was created.
 * @param request The request to order.
 */
case class OrderedEvent(sequence: Long, timestamp: Long, request: NonCommutativeSiriusRequest)