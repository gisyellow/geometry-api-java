/*
 Copyright 1995-2013 Esri

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 For additional information, contact:
 Environmental Systems Research Institute, Inc.
 Attn: Contracts Dept
 380 New York Street
 Redlands, California, USA 92373

 email: contracts@esri.com
 */
package com.esri.core.geometry;

import com.esri.core.geometry.Operator.Type;

/**
 * Generalizes geometries using Douglas-Poiker algorithm.
 */
public abstract class OperatorGeneralize extends Operator {
	@Override
	public Type getType() {
		return Type.Generalize;
	}

	/**
	 * Performs the Generalize operation on the geometry set. Point and
	 * MultiPoint geometries are left unchanged. Envelope is converted to a
	 * Polygon.
	 * 
	 */
	public abstract GeometryCursor execute(GeometryCursor geoms,
			double maxDeviation, boolean bRemoveDegenerateParts,
			ProgressTracker progressTracker);

	/**
	 * Performs the Generalize operation on single geometry. Point and
	 * MultiPoint geometries are left unchanged. Envelope is converted to a
	 * Polygon.
	 */
	public abstract Geometry execute(Geometry geom, double maxDeviation,
			boolean bRemoveDegenerateParts, ProgressTracker progressTracker);

	public static OperatorGeneralize local() {
		return (OperatorGeneralize) OperatorFactoryLocal.getInstance()
				.getOperator(Type.Generalize);
	}

}