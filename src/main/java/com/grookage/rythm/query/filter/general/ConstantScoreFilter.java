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
package com.grookage.rythm.query.filter.general;

import com.grookage.rythm.query.filter.Filter;
import com.grookage.rythm.query.filter.FilterType;
import com.grookage.rythm.query.filter.FilterVisitor;
import lombok.*;

import java.util.List;

@SuppressWarnings("unused")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConstantScoreFilter extends Filter {

    @Singular
    private List<Filter> filters;

    protected ConstantScoreFilter() {
      super(FilterType.CONSTANT_SCORE);
    }

    @Builder
    public ConstantScoreFilter(@Singular List<Filter> filters) {
        super(FilterType.CONSTANT_SCORE);
        this.filters = filters;
    }

    @Override
    public boolean validate() {
      return filters.stream().map(Filter::validate).reduce((x, y) -> x && y).orElse(false);
    }

    @Override
    public <V> V accept(FilterVisitor<V> visitor) {
    return visitor.visit(this);
  }
}

