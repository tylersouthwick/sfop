package net.northfuse.sfop

import org.springframework.web.servlet.View

import java.util.{Map => JMap}

import javax.servlet.http._
import scala.reflect.BeanProperty

class FOPView extends View {

	@BeanProperty
	var renderer : FOPRenderer = null

	final def getContentType = "application/pdf"

	def render(model : JMap[String, _], request : HttpServletRequest, response : HttpServletResponse) {
		renderer.render(response.getOutputStream)
	}
}
