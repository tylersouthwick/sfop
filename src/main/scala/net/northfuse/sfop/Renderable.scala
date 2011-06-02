package net.northfuse.sfop

import scala.xml.Elem

trait Renderable[T] {
	def renderAsElem(name : String) : Elem
}
