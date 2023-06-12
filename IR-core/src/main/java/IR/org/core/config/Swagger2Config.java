package IR.org.core.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

//    @Bean
//    public Docket adminApiConfig(){
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("用户Api")
//                .apiInfo(adminApiInfo())
//                .select()
//                //只显示admin路径下的页面
//                .paths(Predicates.and(PathSelectors.regex("/user/userInfo/.*")))
//                .build();
//
//    }
//
//    private ApiInfo adminApiInfo(){
//
//        return new ApiInfoBuilder()
//                .title("Campus-Help-API文档")
//                .description("本文档描述了Campus-Help用户系统接口")
//                .version("1.0")
//                .contact(new Contact("熊某人", "http://bilibili.com", "1817349047@qq.com"))
//                .build();
//    }

    @Bean
    public Docket LoginApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("登录Api")
                .apiInfo(LoginApiInfo())
                .select()
                //只显示api路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/login/.*")))
                .build();

    }

    private ApiInfo LoginApiInfo(){

        return new ApiInfoBuilder()
                .title("IR-API文档")
                .description("本文档描述了IR用户登录接口")
                .version("1.0")
                .contact(new Contact("lss", "http://bilibili.com", "1817349047@qq.com"))
                .build();
    }
    @Bean
    public Docket PolicyApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("保单Api")
                .apiInfo(PolicyInfo())
                .select()
                //只显示api路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/policyInfo/.*")))
                .build();

    }

    private ApiInfo insuredUserInfo(){

        return new ApiInfoBuilder()
                .title("IR-API文档")
                .description("本文档描述了IR接口")
                .version("1.0")
                .contact(new Contact("lss", "http://bilibili.com", "1817349047@qq.com"))
                .build();
    }

    @Bean
    public Docket insuredUserApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("受保人信息Api")
                .apiInfo(insuredUserInfo())
                .select()
                //只显示api路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/insuredUserInfo/.*")))
                .build();

    }

    private ApiInfo PolicyInfo(){

        return new ApiInfoBuilder()
                .title("IR-API文档")
                .description("本文档描述了IR用户登录接口")
                .version("1.0")
                .contact(new Contact("lss", "http://bilibili.com", "1817349047@qq.com"))
                .build();
    }


//    @Bean
//    public Docket CartApiConfig(){
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("购物车Api")
//                .apiInfo(webApiInfo())
//                .select()
//                //只显示api路径下的页面
//                .paths(Predicates.and(PathSelectors.regex("/divCart/.*")))
//                .build();
//
//    }
//
//    private ApiInfo CartApiInfo(){
//        return new ApiInfoBuilder()
//                .title("DIV好物系统-API文档")
//                .description("本文档描述了DIV好物Cart接口")
//                .version("1.0")
//                .contact(new Contact("熊某人", "http://bilibili.com", "1817349047@qq.com"))
//                .build();
//    }
//
//    @Bean
//    public Docket OrderApiConfig(){
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("订单Api")
//                .apiInfo(webApiInfo())
//                .select()
//                //只显示api路径下的页面
//                .paths(Predicates.and(PathSelectors.regex("/divOrder/.*")))
//                .build();
//
//    }
//
//    private ApiInfo OrderApiInfo(){
//        return new ApiInfoBuilder()
//                .title("DIV好物系统-API文档")
//                .description("本文档描述了DIV好物Order接口")
//                .version("1.0")
//                .contact(new Contact("熊某人", "http://bilibili.com", "1817349047@qq.com"))
//                .build();
//    }
//
//    @Bean
//    public Docket ShopApiConfig(){
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("商品Api")
//                .apiInfo(webApiInfo())
//                .select()
//                //只显示api路径下的页面
//                .paths(Predicates.and(PathSelectors.regex("/divShop/.*")))
//                .build();
//
//    }
//
//    private ApiInfo ShopApiInfo(){
//        return new ApiInfoBuilder()
//                .title("DIV好物系统-API文档")
//                .description("本文档描述了DIV好物Shop接口")
//                .version("1.0")
//                .contact(new Contact("熊某人", "http://bilibili.com", "1817349047@qq.com"))
//                .build();
//    }
}