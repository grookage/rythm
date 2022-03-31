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
package com.grookage.rythm.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grookage.rythm.query.filter.Filter;
import com.grookage.rythm.query.paged.PageWindow;
import com.grookage.rythm.query.sorter.Sorter;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("unused")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Query {

    public static String RAW_QUERY_NAME = "rawQuery";
    @NotNull
    public PageWindow pageWindow;
    @Builder.Default
    private String queryName = "query";
    @JsonProperty
    @NotNull
    @Builder.Default
    private Set<Filter> filters = new HashSet<>();
    @JsonProperty
    @NotNull
    @Builder.Default
    private Set<Sorter> sorters = new TreeSet<>();

    public void addFilter(Filter filter) {
        if (Objects.isNull(filters) || filters.isEmpty()) {
            this.filters = new HashSet<>();
        }
        this.filters.add(filter);
    }

    public void addJElasticSorter(Sorter sorter) {
        if (Objects.isNull(sorters) || sorters.isEmpty()) {
            this.sorters = new TreeSet<>();
        }

        this.sorters.add(sorter);
    }
}
