package net.northfuse.sfop

import scala.xml.Elem

trait LayoutMaster extends Renderable[String]

trait SimplePageMaster extends LayoutMaster {
	val pageHeight : String
	val pageWidth : String
	val margin : String

	def renderAsElem(name : String) = {
		<simple-page-master master-name={name}
			page-height={pageHeight} page-width={pageWidth}
			margin={margin}>
			<region-body/>
		</simple-page-master>
	}
}

trait PageSequenceMaster extends LayoutMaster {
	def renderAsElem(name : String) = null
}
