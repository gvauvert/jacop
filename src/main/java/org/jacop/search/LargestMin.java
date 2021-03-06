/**
 *  LargestMin.java
 *  This file is part of JaCoP.
 *
 *  JaCoP is a Java Constraint Programming solver.
 *
 *	Copyright (C) 2000-2008 Krzysztof Kuchcinski and Radoslaw Szymanek
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  Notwithstanding any other provision of this License, the copyright
 *  owners of this work supplement the terms of this License with terms
 *  prohibiting misrepresentation of the origin of this work and requiring
 *  that modified versions of this work be marked in reasonable ways as
 *  different from the original version. This supplement of the license
 *  terms is in accordance with Section 7 of GNU Affero General Public
 *  License version 3.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.jacop.search;

import org.jacop.core.IntVar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines a LargestMin comparator for Variables.
 *
 * @author Krzysztof Kuchcinski and Radoslaw Szymanek
 * @version 4.2
 * @param <T> type of IntVar being compared.
 */

public class LargestMin<T extends IntVar> implements ComparatorVariable<T> { private static Logger logger = LoggerFactory.getLogger(LargestMin.class);

	/**
	 * It constructs variable comparator with priority based on the largest minimal value.
	 */
	public LargestMin() {
	}

	public int compare(float left, T var) {
		int right = var.dom().min();
		if (left > right)
			return 1;
		if (left < right)
			return -1;
		return 0;
	}

	public int compare(T leftVar, T rightVar) {
		int left = leftVar.dom().min();
		int right = rightVar.dom().min();
		if (left > right)
			return 1;
		if (left < right)
			return -1;
		return 0;
	}

	public float metric(T var) {
		return var.dom().min();
	}

}
