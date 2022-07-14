// Copyright 2022 Llamas
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package chat.llamas.cardlogic.domain;

public enum HandResultType {
	BETTER_THAN_ROYAL_FLUSH(true),
	ROYAL_FLUSH(false),
	STRAIGHT_FLUSH(false),
	FOUR_KIND(false),
	FULL_HOUSE(false),
	FLUSH(false),
	STRAIGHT(false),
	FOUR_FLUSH(true),
	THREE_KIND(false),
	TWO_PAIR(false),
	PAIR(false),
	HIGH(false),
	NONE(false);
	
	private boolean custom;
	HandResultType(boolean custom) {
		this.custom = custom;
	}
	
	public boolean isCustom() {
		return custom;
	}
	
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
}
