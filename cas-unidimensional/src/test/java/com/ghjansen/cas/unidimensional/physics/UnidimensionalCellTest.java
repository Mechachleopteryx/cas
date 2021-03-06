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

package com.ghjansen.cas.unidimensional.physics;

import org.junit.Assert;
import org.junit.Test;

import com.ghjansen.cas.core.ca.Combination;
import com.ghjansen.cas.core.ca.State;
import com.ghjansen.cas.core.ca.Transition;
import com.ghjansen.cas.core.exception.InvalidCombinationException;
import com.ghjansen.cas.core.exception.InvalidStateException;
import com.ghjansen.cas.core.exception.InvalidTransitionException;
import com.ghjansen.cas.core.physics.Cell;
import com.ghjansen.cas.unidimensional.ca.UnidimensionalCombination;
import com.ghjansen.cas.unidimensional.ca.UnidimensionalState;
import com.ghjansen.cas.unidimensional.ca.UnidimensionalTransition;

/**
 * @author Guilherme Humberto Jansen (contact.ghjansen@gmail.com)
 */
public class UnidimensionalCellTest {

	@Test
	public void unidimensionalCellConstructor()
			throws InvalidStateException, InvalidCombinationException, InvalidTransitionException {
		final State unidimensionalBlackState = new UnidimensionalState("black", 0);
		final State unidimensionalWhiteState = new UnidimensionalState("white", 1);
		final Combination unidimensionalCombination = new UnidimensionalCombination(unidimensionalBlackState,
				unidimensionalWhiteState, unidimensionalBlackState);
		final Transition unidimensionalTransition = new UnidimensionalTransition(unidimensionalCombination,
				unidimensionalWhiteState);
		final Cell unidimensionalCell = new UnidimensionalCell(unidimensionalTransition);
		Assert.assertTrue(unidimensionalCell.getTransition().equals(unidimensionalTransition));
		Assert.assertTrue(unidimensionalCell.getState().equals(unidimensionalTransition.getState()));
	}

}
