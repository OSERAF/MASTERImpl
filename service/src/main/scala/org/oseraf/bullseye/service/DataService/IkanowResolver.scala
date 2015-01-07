package org.oseraf.bullseye.service.DataService

import no.priv.garshol.duke.{Record, Configuration}
import org.oseraf.bullseye.store.{WriteEventPublisherPlugin, EntityIterationPlugin, EntityStore}

class IkanowResolver(
                      store:EntityStore with EntityIterationPlugin with WriteEventPublisherPlugin,
                      dukeConf: Configuration) extends DukeResolver(store, dukeConf) {

  override def compare(targetRecord:EntityRecord, candidateRecord:Record):Option[BullsEyeEntityScore] = {
    if(targetRecord.getProperties().contains("Date") || candidateRecord.getProperties().contains("Date")) {
      None
    }
    else {
      super.compare(targetRecord, candidateRecord)
    }
  }

}
