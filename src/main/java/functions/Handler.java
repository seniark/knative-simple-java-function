/*
 * Copyright 2021-2022 VMware, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package functions;

import java.util.function.Function;

/*
This class demonstrates the definition of a function called "Handler".
This function can be accessed by targetting the "/handler" path while
providing the correct data. Please see the README for HTTP or
CloudEvents data as needed.

If this is the only function defined, it may be accessed via "/"
path.
*/
public class Handler implements Function<String,String> {
    @Override
    public String apply(String name) {
        System.out.printf("Hello" + name);
        return "Hello " + name;
    }
}
