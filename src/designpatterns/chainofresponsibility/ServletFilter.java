package designpatterns.chainofresponsibility;

/**
 * @author fengjie
 * @date 2019:03:21
 */
public class ServletFilter implements Filter {
    @Override
    public void dofilter(Request request, Reponse response, Filter filter) {
        request.request = request.request + "--ServletFilterRequest";
        filter.dofilter(request, response, filter);
        response.reponse = request.request + "--ServletFilterResponse";
    }
}
