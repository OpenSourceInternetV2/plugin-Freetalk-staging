/* This code is part of Freenet. It is distributed under the GNU General
 * Public License, version 2 (or at your option any later version). See
 * http://www.gnu.org/ for further details of the GPL. */
package plugins.FMSPlugin.WoT;

import java.util.Collection;
import java.util.Iterator;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import freenet.support.Executor;
import plugins.FMSPlugin.FMSIdentity;
import plugins.FMSPlugin.FMSIdentityManager;
import plugins.FMSPlugin.FMSOwnIdentity;

import plugins.WoT.WoT;
import plugins.WoT.Identity;
import plugins.WoT.OwnIdentity;

/**
 * An identity manager which uses the identities from the WoT plugin.
 * 
 * @author xor
 *
 */
public class FMSIdentityManagerWoT extends FMSIdentityManager {
	
	private WoT mWoT;

	/**
	 * @param executor
	 */
	public FMSIdentityManagerWoT(ObjectContainer myDB, Executor executor, WoT newWoT) {
		super(myDB, executor);
		mWoT = newWoT;
	}
}
