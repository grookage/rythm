/*
 * Copyright 2021 Koushik R <rkoushik.14@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.grookage.rythm.query.sorter;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("unused")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ScoreSorter extends Sorter {

    public ScoreSorter(){super(SorterType.SCORE);}

    @Builder
    public ScoreSorter(int priority, SortOrder sortOrder) {
      super(priority, sortOrder, SorterType.SCORE);
    }

    @Override
    public <V> V accept(SorterVisitor<V> visitor) {
      return visitor.visit(this);
    }
}
