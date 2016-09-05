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

package com.ghjansen.cas.core.ca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Guilherme Humberto Jansen (contact.ghjansen@gmail.com)
 */
public abstract class Combination {

	private State reference;
	private List<State> neighborhood;

	public Combination(State reference, State... neighbors) {
		this.reference = reference;
		this.neighborhood = new ArrayList<State>();
		for (int i = 0; i < neighbors.length; i++) {
			this.neighborhood.add(neighbors[i]);
		}
	}

	public State getReferenceState() {
		return reference;
	}

	public List<State> getNeighborhood() {
		return this.neighborhood;
	}
	
	//TODO migrate this method to rule
	public boolean isGeneralEquivalent(Combination combination){
		if(this.reference.equals(combination.getReferenceState())){
			for(int i = 0; i < this.neighborhood.size(); i++){
				List<State> differentNeighborhood = combination.getNeighborhood();
				if(!this.neighborhood.get(i).equals(differentNeighborhood.get(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}