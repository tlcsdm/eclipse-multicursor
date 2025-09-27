# MultiCursor

An aborted attempt to provide Sublime-Text-like multi cursor support for text editors in the Eclipse IDE.

Fork of [eclipse-multicursor](https://github.com/caspark/eclipse-multicursor) on Github

## Use
- **Select All Same Words (All):** `Ctrl+Alt+F`  
  (Place the cursor on a word and press the shortcut to select all occurrences. Then type to change them.  
  *Note: does not support adjacent matches, e.g., `ssss` searching for `ss`.*)

- **Select Same Word (Next, Next):** `Ctrl+Alt+D`  
  (Place the cursor on a word and press the shortcut to select the next occurrence. Then type to change it.  
  *Note: does not support adjacent matches, e.g., `ssss` searching for `ss`.*)

- **Select Remaining Same Words (Rest All):** `Ctrl+Alt+N`  
  (Place the cursor on a word and press the shortcut to select all remaining occurrences. Then type to change them.  
  *Note: does not support adjacent matches, e.g., `ssss` searching for `ss`.*)

- **Custom Multiple Selections (Multiple Positions):** `Ctrl+Alt+V`  
  (Place the cursor at the desired insertion point and press the shortcut to mark it.)

## Build

This project uses [Tycho](https://github.com/eclipse-tycho/tycho) with [Maven](https://maven.apache.org/) to build. It requires Maven 3.9.0 or higher version.

Dev build:

```
mvn clean verify
```

Release build:

```
mvn clean org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=2.0.0 verify
```

## Install
1. Add `https://raw.githubusercontent.com/tlcsdm/eclipse-multicursor/master/update_site/` as the upgrade location in Eclipse.
2. Download from [Jenkins](https://jenkins.tlcsdm.com/job/eclipse-plugin/job/eclipse-multicursor)
3. <table style="border: none;">
  <tbody>
    <tr style="border:none;">
      <td style="vertical-align: middle; padding-top: 10px; border: none;">
        <a href='http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=6997461' title='Drag and drop into a running Eclipse Indigo workspace to install eclipse-multicursor'> 
          <img src='https://marketplace.eclipse.org/modules/custom/eclipsefdn/eclipsefdn_marketplace/images/btn-install.svg'/>
        </a>
      </td>
      <td style="vertical-align: middle; text-align: left; border: none;">
        ← Drag it to your eclipse workbench to install! (I recommand Main Toolbar as Drop Target)
      </td>
    </tr>
  </tbody>
</table>

