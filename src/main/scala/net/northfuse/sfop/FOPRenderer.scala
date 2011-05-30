package net.northfuse.sfop

import org.apache.fop.apps._
import javax.xml.transform.stream.StreamSource
import javax.xml.transform._
import javax.xml.transform.sax._
import scala.xml.Elem
import java.io._
import org.apache.fop.apps.MimeConstants
import MimeConstants._

object FOPRenderer {
	val fopFactory = FopFactory.newInstance
	val transferFactory = TransformerFactory.newInstance
	val LOG = org.apache.log4j.Logger.getLogger(classOf[FOPRenderer])
}

trait FOPRenderer {
	import FOPRenderer._

	/**
	 * Build an XML tree
	 *
	 * @return An Elem containing an FOP tree
	 */
	protected def buildXML: Elem

        //TODO find a more efficient way to convert an Elem to a Source
	implicit def toStreamSource(x: Elem): Source = {
		println(x.toString)
		new StreamSource(new StringReader(x.toString))
	}

	/**
	 * Generate a PDF to an output stream
	 * @param os OutputStream
	 */
	def render(os: OutputStream) = {
		val fop = fopFactory.newFop(MIME_PDF, os)
		val transformer = transferFactory.newTransformer
		val result = new SAXResult(fop.getDefaultHandler())
		transformer.transform(buildXML, result)
		os.close
	}

}

