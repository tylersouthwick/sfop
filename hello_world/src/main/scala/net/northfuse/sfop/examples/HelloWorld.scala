package net.northfuse.sfop.examples

import net.northfuse.sfop._

object HelloWorld extends FOPDocument {
import FOPDocument.foNamespace
val name = "somebody"
	
	content += new Content {
		val name = "test"

		val layout = new SimplePageMaster {
			val pageHeight = "29.7cm"
			val pageWidth = "21.0cm"
			val margin = "2cm"
		}

		val content = PageSequence {
			<fo:flow flow-name="xsl-region-body">
				<fo:block>
					Hello, {name}!
				</fo:block>
			</fo:flow>
		}
	}
}
