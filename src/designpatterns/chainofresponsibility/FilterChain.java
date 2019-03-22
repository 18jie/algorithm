package designpatterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @date 2019:03:21
 */
public class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();
    int index;

    public FilterChain addFilter(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    @Override
    public void dofilter(Request request, Reponse response, Filter filter) {
        if (index == filters.size()) return;
        Filter filter1 = filters.get(index);
        index++;
        filter1.dofilter(request, response, filter);
    }
}
