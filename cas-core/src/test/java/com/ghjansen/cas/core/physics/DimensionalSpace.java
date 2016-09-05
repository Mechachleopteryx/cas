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

import java.util.List;

import com.ghjansen.cas.core.ca.Combination;
import com.ghjansen.cas.core.ca.Transition;
import com.ghjansen.cas.core.physics.exception.space.InvalidDimensionalAmount;
import com.ghjansen.cas.core.physics.exception.space.InvalidDimensionalSpace;
import com.ghjansen.cas.core.physics.exception.space.InvalidInitialCondition;

/**
 * @author Guilherme Humberto Jansen (contact.ghjansen@gmail.com)
 */
public class DimensionalSpace extends Space {

	protected DimensionalSpace(Time time, List<?> initialCondition, boolean keepHistory)
			throws InvalidDimensionalAmount, InvalidInitialCondition, InvalidDimensionalSpace {
		super(time, initialCondition, keepHistory);
	}

	@Override
	protected Combination getCombination(Time time, List<?> space) {
		// Since this method is declared as abstract in core module, its
		// implementation and tests should be created inside each dimensional
		// module.
		return null;
	}

	@Override
	protected void initialize() {
		// Since this method is declared as abstract in core module, its
		// implementation and tests should be created inside each dimensional
		// module.
	}

	@Override
	protected void createNewIteration(Time time) {
		// Since this method is declared as abstract in core module, its
		// implementation and tests should be created inside each dimensional
		// module.
	}

	@Override
	protected void createNewCell(Time time, Transition transition) {
		// Since this method is declared as abstract in core module, its
		// implementation and tests should be created inside each dimensional
		// module.
	}

}