package net.northfuse.sfop

import scala.xml.Elem

trait Content {
	val layout : LayoutMaster
	val content : PageSequence
	val name : String

	final def layoutMaster = layout.renderAsElem(name)
	final def pageSequence = content.renderAsElem(name)
}
