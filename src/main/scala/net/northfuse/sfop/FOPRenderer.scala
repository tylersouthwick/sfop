package net.northfuse.sfop

import org.apache.fop.apps._
import javax.xml.transform.stream.StreamSource
import javax.xml.transform._
import javax.xml.transform.sax._
import scala.xml.Elem
import java.io._

object FOPRenderer {
	val fopFactory = FopFactory.newInstance
	val transferFactory = TransformerFactory.newInstance
	val LOG = org.apache.log4j.Logger.getLogger(classOf[FOPRenderer])
}

trait FOPRenderer {
	import FOPRenderer.{LOG, transferFactory}

	/**
	 * override this with a custom factory if wanted
	 */
	val fopFactory = FOPRenderer.fopFactory

	/**
	 * Build an XML tree
	 *
	 * @return An Elem containing an FOP tree
	 */
	protected def buildXML: Elem

        //TODO find a more efficient way to convert an Elem to a Source
	implicit def toStreamSource(x: Elem): Source = {
		if (LOG.isDebugEnabled) {
			val file = File.createTempFile("sfop", ".fo.xml")
			val out = new FileOutputStream(file)
			out.write(x.toString().getBytes)
			out.close()
			LOG.debug("SFOP output: " + file.getAbsolutePath)
		}
		new StreamSource(new StringReader(x.toString()))
	}

	/**
	 * Generate a PDF to an output stream
	 * @param os OutputStream
	 */
	final def render(os: OutputStream) {
		renderPDF(os)
	}

	final def renderPDF(os: OutputStream) {
		render("application/pdf", os)
	}

	final def render(outputType : String, os: OutputStream) {
		val fop = fopFactory.newFop(outputType, os)
		val transformer = transferFactory.newTransformer
		val result = new SAXResult(fop.getDefaultHandler)
		transformer.transform(buildXML, result)
		os.close()
	}

}

