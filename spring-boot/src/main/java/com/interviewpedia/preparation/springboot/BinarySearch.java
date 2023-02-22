package com.interviewpedia.preparation.springboot;

import com.interviewpedia.preparation.springboot.sort.SortAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <p><b>Constructor-injection vs Setter-injection</b></p>
 *      <p>- if paramterized constructor is available, then constructor-injection happens, and the following DEBUG log message gets printed:
 *          <i>Autowiring by type from bean name 'binarySearch' via constructor to bean named 'bubbleSort'</i></p>
 *
 *      <p>- if (instead of the constructor) a setter is available, then the setter-injection happens, and the following DEBUG log message gets printed
 *          <i>Autowiring by type from bean name 'binarySearch' to bean named 'bubbleSort'</i></p>
 *
 *      <p>- if neither constructor nor the setter are available, then the setter-injection happens, and the following DEBUG log message gets printed
 *          <i>Autowiring by type from bean name 'binarySearch' to bean named 'bubbleSort'</i></p>
 *
 *      <p>So, if the constructor is available then constructor-injection happens, otherwise setter-injection happens.
 *      However, if both constructor and setter are available, then also constructor-injection happens</p>
 *
 *
 * <p><b>Autowiring:</b></p>
 *      <p><b>1. Autowiring by type</b> - By default, Spring resolves @Autowired entries by type. If more than one bean of the same type is available in
 *      the container, the framework will throw a fatal exception. To resolve this conflict, we need to tell Spring explicitly which bean we want to inject.</p>
 *
 *      <p><b>2. Autowiring by @Qualifier</b> -<br/></p>
 *
 * <pre> {@code
 * @Component("fooFormatter")
 * public class FooFormatter implements Formatter {
 *     public String format() {
 *         return "foo";
 *     }
 * }
 *
 * @Component("barFormatter")
 * public class BarFormatter implements Formatter {
 *     public String format() {
 *         return "bar";
 *     }
 * }
 *
 * public class FooService {
 *     @Autowired
 *     private Formatter formatter;
 * }
 * }</pre>
 *
 * <p>In our example, there are two concrete implementations of Formatter available for the Spring container.
 * As a result, Spring will throw a NoUniqueBeanDefinitionException exception when constructing the FooService:</p>
 *
 * <p>Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException:
 * No qualifying bean of type [com.autowire.sample.Formatter] is defined:
 * expected single matching bean but found 2: barFormatter,fooFormatter</p>
 *
 * <p>This ambiguity can be resolved using @Qualifier annotation.</p>
 * <pre> {@code
 * public class FooService {
 *     @Autowired
 *     @Qualifier("fooFormatter")
 *     private Formatter formatter;
 * }
 * }</pre>
 *
 * <p><b>3. Autowiring by name</b> - Spring uses the bean's name as a default qualifier value. It will inspect the container
 * and look for a bean with the exact name as the property to autowire it.</p>
 *
 * <pre> {@code
 * public class FooService {
 *     @Autowired
 *     private Formatter fooFormatter;
 * }
 * }</pre>
 *
 * <p><b>@Primary annotation</b> - we use @Primary to give higher preference to a bean when there are multiple beans of the same type.</p>
 * <pre> {@code
 * @Configuration
 * public class Config {
 *
 *     @Bean
 *     public Employee JohnEmployee() {
 *         return new Employee("John");
 *     }
 *
 *     @Bean
 *     public Employee TonyEmployee() {
 *         return new Employee("Tony");
 *     }
 * }
 * }</pre>
 *
 * <p>Spring will throw <b>NoUniqueBeanDefinitionException</b> if we try to run the above code. To access beans with the same type
 * we usually use <b>@Qualifier(“beanName”)</b> annotation. We apply it at the injection point along with <b>@Autowired</b>. In our case,
 * we select the beans at the configuration phase so <b>@Qualifier</b> can't be applied here. To resolve this issue Spring offers the <b>@Primary</b> annotation.</p>
 *
 * <p>We mark TonyEmployee() bean with @Primary. Spring will inject TonyEmployee() bean preferentially over the JohnEmployee().</p>
 * <pre> {@code
 * @Configuration
 * public class Config {
 *
 *     @Bean
 *     public Employee JohnEmployee() {
 *         return new Employee("John");
 *     }
 *
 *     @Bean
 *     @Primary
 *     public Employee TonyEmployee() {
 *         return new Employee("Tony");
 *     }
 * }
 * }</pre>
 *
 * https://www.baeldung.com/spring-primary
 */

@Service
public class BinarySearch {
    private static final Logger logger = LoggerFactory.getLogger(BinarySearch.class);

    @Autowired
    private SortAlgorithm sortAlgorithm;

//    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm = sortAlgorithm;
//    }

    public BinarySearch(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int search(int[] numbers, int number) {
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(sortAlgorithm);

        // search the number in sorted array
        return 3;
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("preDestroy");
    }
}
