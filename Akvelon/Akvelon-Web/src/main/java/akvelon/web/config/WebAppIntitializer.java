/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.web.config;



import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 *
 * @author Жека
 */
public class WebAppIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {WebConfig.class}; // We dont need any special servlet config yet.
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
    
}
