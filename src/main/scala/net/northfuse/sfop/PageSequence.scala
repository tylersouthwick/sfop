package net.northfuse.sfop
import scala.xml.Elem

object PageSequence {
	def apply(builder : => Elem) = new PageSequence {
		val body = builder
	}
}

trait PageSequence extends Renderable[String] {
	val body : Elem

	final def renderAsElem(name : String) = {
		<page-sequence master-reference={name}>
			{body}
		</page-sequence>
	}
}
