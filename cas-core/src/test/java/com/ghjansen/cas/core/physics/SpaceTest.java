/*
 * CAS - Cellular Automata Simulator
 * Copyright (C) 2016  Guilherme Humberto Jansen
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ghjansen.cas.core.physics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ghjansen.cas.core.ca.Combination;
import com.ghjansen.cas.core.ca.DimensionalCombination;
import com.ghjansen.cas.core.ca.Transition;
import com.ghjansen.cas.core.physics.exception.space.InvalidDimensionalAmount;
import com.ghjansen.cas.core.physics.exception.space.InvalidDimensionalSpace;
import com.ghjansen.cas.core.physics.exception.space.InvalidInitialCondition;
import com.ghjansen.cas.core.physics.exception.time.InvalidAbsoluteTimeLimit;
import com.ghjansen.cas.core.physics.exception.time.InvalidRelativeTimeLimit;
import com.ghjansen.cas.core.ca.DimensionalState;
import com.ghjansen.cas.core.ca.DimensionalTransition;
import com.ghjansen.cas.core.ca.State;

/**
 * @author Guilherme Humberto Jansen (contact.ghjansen@gmail.com)
 */
public class SpaceTest {

	@Test
	public void dimensionalTimeConstructor() throws CloneNotSupportedException, InvalidAbsoluteTimeLimit,
			InvalidRelativeTimeLimit, InvalidDimensionalAmount, InvalidInitialCondition, InvalidDimensionalSpace {
		Time time = new DimensionalTime(1000, 1000);
		State reference = new DimensionalState();
		State leftNeighbor = new DimensionalState();
		State rightNeighbor = new DimensionalState();
		State newState = new DimensionalState();
		Combination combination = new DimensionalCombination(reference, leftNeighbor, rightNeighbor);
		Transition transition = new DimensionalTransition(combination, newState);
		DimensionalCell cell = new DimensionalCell(transition);
		ArrayList<Cell> firstDimension = new ArrayList<Cell>();
		firstDimension.add(cell);
		new DimensionalSpace(time, firstDimension, true);
	}

	@Test(expected = InvalidInitialCondition.class)
	public void dimensionalTimeConstructorInvalidInitialCondition()
			throws CloneNotSupportedException, InvalidAbsoluteTimeLimit, InvalidRelativeTimeLimit,
			InvalidDimensionalAmount, InvalidInitialCondition, InvalidDimensionalSpace {
		Time time = new DimensionalTime(1000, 1000);
		new DimensionalSpace(time, null, true);
	}

	@Test(expected = InvalidDimensionalSpace.class)
	public void dimensionalTimeConstructorInvalidDimensionalSpace()
			throws CloneNotSupportedException, InvalidAbsoluteTimeLimit, InvalidRelativeTimeLimit,
			InvalidDimensionalAmount, InvalidInitialCondition, InvalidDimensionalSpace {
		Time time = new DimensionalTime(1000, 1000);
		State reference = new DimensionalState();
		State leftNeighbor = new DimensionalState();
		State rightNeighbor = new DimensionalState();
		State newState = new DimensionalState();
		Combination combination = new DimensionalCombination(reference, leftNeighbor, rightNeighbor);
		Transition transition = new DimensionalTransition(combination, newState);
		DimensionalCell cell = new DimensionalCell(transition);
		ArrayList<List> firstDimension = new ArrayList<List>();
		ArrayList<Cell> secondDimension = new ArrayList<Cell>();
		firstDimension.add(secondDimension);
		secondDimension.add(cell);
		new DimensionalSpace(time, firstDimension, true);
	}

}
