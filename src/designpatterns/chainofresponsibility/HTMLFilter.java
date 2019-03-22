package designpatterns.chainofresponsibility;

/**
 * @author fengjie
 * @date 2019:03:21
 */
public class HTMLFilter implements Filter {
    @Override
    public void dofilter(Request request, Reponse response, Filter filter) {
        request.request = request.request.replace("<", "") + "HTMLfilterRequest";
        filter.dofilter(request, response, filter);
        response.reponse = response.reponse + "--HTMLfilterReponse";
    }
}
