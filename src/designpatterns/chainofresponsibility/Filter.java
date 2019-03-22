package designpatterns.chainofresponsibility;

/**
 * 责任链模式 filter接口
 *
 * @author fengjie
 * @date 2019:03:21
 */
public interface Filter {

    public void dofilter(Request request,Reponse response,Filter filter);

}
