/* This code is part of Freenet. It is distributed under the GNU General
 * Public License, version 2 (or at your option any later version). See
 * http://www.gnu.org/ for further details of the GPL. */
package plugins.Freetalk.ui.web;

import java.util.Iterator;

import plugins.Freetalk.Board;
import plugins.Freetalk.FTOwnIdentity;
import plugins.Freetalk.Freetalk;
import freenet.support.HTMLNode;
import freenet.support.api.HTTPRequest;

public class BoardsPage extends WebPageImpl {

	public BoardsPage(Freetalk ft, FTOwnIdentity viewer, HTTPRequest request) {
		super(ft, viewer, request);
		// TODO Auto-generated constructor stub
	}

	public void make() {
		makeBoardsList();
	}

	private void makeBoardsList() {
		HTMLNode boardsBox = getContentBox("Boards");
		
		// Display the list of known identities
		HTMLNode boardsTable = boardsBox.addChild("table", "border", "0");
		HTMLNode row = boardsTable.addChild("tr");
		row.addChild("th", "Name");
		row.addChild("th", "Description");
		row.addChild("th", "Messages");
		
		/* FIXME: Currently we show all boards. We should rather show the boards which the identity has selected */
		Iterator<Board> boards = mFreetalk.getMessageManager().boardIterator();
		while(boards.hasNext()) {
			Board board = boards.next();
			row = boardsTable.addChild("tr");
			
			HTMLNode nameCell = row.addChild("th", new String[] { "align" }, new String[] { "left" });
			nameCell.addChild(new HTMLNode("a", "href", SELF_URI + "/showBoard?identity=" + mOwnIdentity.getUID() + "&name=" + board.getName(), board.getName()));

			/* Description */
			row.addChild("td", new String[] { "align" }, new String[] { "center" }, "not implemented yet");
	
			/* Message count */
			row.addChild("td", new String[] { "align" }, new String[] { "center" }, Integer.toString(board.messageCount()));
		}
	}

}