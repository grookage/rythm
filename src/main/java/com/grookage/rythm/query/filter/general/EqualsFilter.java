/*
 * Copyright 2019 Koushik R <rkoushik.14@gmail.com>.
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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by koushikr
 */
@SuppressWarnings("unused")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EqualsFilter extends Filter {

    private Object value;

    public EqualsFilter() {
        super(FilterType.EQUAL);
    }

    public EqualsFilter(String operator) {
        super(operator);
    }

    public EqualsFilter(String operator, String field) {
        super(operator, field);
    }

    public EqualsFilter(String field, Object value) {
        super(FilterType.EQUAL, field);
        this.value = value;
    }

    public EqualsFilter(String operator, String field, Object value) {
        super(operator, field);
        this.value = value;
    }

    @Override
    public <V> V accept(FilterVisitor<V> visitor) {
        return visitor.visit(this);
    }

}
