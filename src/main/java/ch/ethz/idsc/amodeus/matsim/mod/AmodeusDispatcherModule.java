/* amodeus - Copyright (c) 2018, ETH Zurich, Institute for Dynamic Systems and Control */
package ch.ethz.idsc.amodeus.matsim.mod;

import org.matsim.core.controler.AbstractModule;

import ch.ethz.idsc.amodeus.dispatcher.AdaptiveRealTimeRebalancingPolicy;
import ch.ethz.idsc.amodeus.dispatcher.DemandSupplyBalancingDispatcher;
import ch.ethz.idsc.amodeus.dispatcher.DriveByDispatcher;
import ch.ethz.idsc.amodeus.dispatcher.FeedforwardFluidicRebalancingPolicy;
import ch.ethz.idsc.amodeus.dispatcher.FeedforwardFluidicTimeVaryingRebalancingPolicy;
import ch.ethz.idsc.amodeus.dispatcher.GlobalBipartiteMatchingDispatcher;
import ch.ethz.idsc.amodeus.dispatcher.SQMDispatcher;
import ch.ethz.idsc.amodeus.dispatcher.shared.ExtDemandSupplyBeamSharing;
import ch.ethz.idsc.amodeus.dispatcher.shared.NorthPoleSharedDispatcher;
import ch.ethz.idsc.amodeus.dispatcher.shared.kockelman.FagnantKockelmanDispatcherShared;
import ch.ethz.idsc.amodeus.dispatcher.shared.kockelman.FagnantKockelmanDispatcherSingle;
import ch.ethz.matsim.av.framework.AVUtils;

public class AmodeusDispatcherModule extends AbstractModule {
    @Override
    public void install() {
        /** dispatchers for UniversalDispatcher */

        bind(DriveByDispatcher.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), DriveByDispatcher.class.getSimpleName()).to(DriveByDispatcher.Factory.class);

        bind(DemandSupplyBalancingDispatcher.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), DemandSupplyBalancingDispatcher.class.getSimpleName()).to(DemandSupplyBalancingDispatcher.Factory.class);

        bind(GlobalBipartiteMatchingDispatcher.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), GlobalBipartiteMatchingDispatcher.class.getSimpleName()).to(GlobalBipartiteMatchingDispatcher.Factory.class);

        bind(FagnantKockelmanDispatcherSingle.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), FagnantKockelmanDispatcherSingle.class.getSimpleName()).to(FagnantKockelmanDispatcherSingle.Factory.class);

        /** dispatchers for PartitionedDispatcher */

        bind(AdaptiveRealTimeRebalancingPolicy.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), AdaptiveRealTimeRebalancingPolicy.class.getSimpleName()).to(AdaptiveRealTimeRebalancingPolicy.Factory.class);

        bind(FeedforwardFluidicRebalancingPolicy.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), FeedforwardFluidicRebalancingPolicy.class.getSimpleName()).to(FeedforwardFluidicRebalancingPolicy.Factory.class);

        bind(FeedforwardFluidicTimeVaryingRebalancingPolicy.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), FeedforwardFluidicTimeVaryingRebalancingPolicy.class.getSimpleName())
                .to(FeedforwardFluidicTimeVaryingRebalancingPolicy.Factory.class);

        bind(SQMDispatcher.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), SQMDispatcher.class.getSimpleName()).to(SQMDispatcher.Factory.class);

        /** ride sharing dispatchers */
        bind(NorthPoleSharedDispatcher.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), NorthPoleSharedDispatcher.class.getSimpleName()).to(NorthPoleSharedDispatcher.Factory.class);

        bind(ExtDemandSupplyBeamSharing.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), ExtDemandSupplyBeamSharing.class.getSimpleName()).to(ExtDemandSupplyBeamSharing.Factory.class);

        bind(FagnantKockelmanDispatcherShared.Factory.class);
        AVUtils.bindDispatcherFactory(binder(), FagnantKockelmanDispatcherShared.class.getSimpleName()).to(FagnantKockelmanDispatcherShared.Factory.class);

    }
}
