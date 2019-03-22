package designpatterns.chainofresponsibility;

/**
 * 测试责任链模式主类
 *
 * @author fengjie
 * @date 2019:03:21
 */
public class Go {

    public static void main(String[] args) {
        Request request = new Request();
        request.request = "<这是内容>";
        Reponse reponse = new Reponse();
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter());
        filterChain.addFilter(new ServletFilter());
        filterChain.dofilter(request, reponse, filterChain);
        System.out.println(reponse.reponse);
    }

}
