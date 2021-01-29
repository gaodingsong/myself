package com.example.controller;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/1/27 16:11
 * @version:1.0
 */
public class GuavaController {
    public static void main(String[] args) {
        Joiner joiner = Joiner.on("; ").skipNulls();

//        List<String> objects = Lists.newArrayList();
//        objects.add("Harry");
//        objects.add("Ron");
//        objects.add("Hermione");
//        joiner.join(objects);
//        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
//        System.out.println(joiner.join(objects));
//
//
//
//        Iterable<Integer> concatenated = Iterables.concat(
//                Ints.asList(1, 2, 3),
//                Ints.asList(4, 5, 6));
//
//
//        Integer lastAdded = Iterables.getLast(concatenated,2);
//        String onlyElement = Iterables.getOnlyElement(objects);
//        List<Integer> list = new ArrayList<>();
//        Integer first =  Iterables.getFirst(concatenated,1);
//        System.out.println(onlyElement);

//        Optional<Integer> possible = Optional.of(null);
//       ; // returns true
//        System.out.println(possible.isPresent());
//
//


        Lists.newArrayListWithCapacity(10);


        Iterable<String> split = Splitter.on(',').omitEmptyStrings().trimResults().split("   foo,bar,,   qux    ");

        split.forEach(s->{
            System.out.println(s);
        });




    }


}
