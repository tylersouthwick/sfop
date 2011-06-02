package net.northfuse.sfop
import scala.xml.Elem

trait PageSequence extends Renderable[String] with ContentHolder[Flow] {

	final def renderAsElem(name : String) = {
		<page-sequence master-reference={name}>
			{renderContents}
		</page-sequence>
	}
}
