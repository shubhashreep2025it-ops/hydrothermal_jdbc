const API = "/api";


// =====================================================
// NAVIGATION
// =====================================================

function showSection(sectionId, button) {

    const sections =
        document.querySelectorAll(".section");

    sections.forEach(section => {
        section.classList.remove("active");
    });


    const selectedSection =
        document.getElementById(sectionId);

    if (selectedSection) {
        selectedSection.classList.add("active");
    }


    document
        .querySelectorAll(".nav-btn")
        .forEach(btn => {

            btn.classList.remove("active");

        });


    if (button) {
        button.classList.add("active");
    }


    const titles = {

        dashboard:
            [
                "Smart Greenhouse Management",
                "Hydro-Thermal Energy Storage System"
            ],

        zones:
            [
                "Greenhouse Zones",
                "Manage your cultivation zones"
            ],

        thermal:
            [
                "Thermal Monitoring",
                "Monitor thermal storage and energy delivery"
            ],

        purchasing:
            [
                "Purchasing",
                "Manage procurement activities"
            ],

        sales:
            [
                "Sales Management",
                "Manage customer orders and payments"
            ],

        accounting:
            [
                "Accounting",
                "Manage financial records"
            ],

        budget:
            [
                "Seasonal Zone Budget",
                "Plan and monitor greenhouse expenses"
            ]

    };


    if (titles[sectionId]) {

        document.getElementById("pageTitle")
            .textContent = titles[sectionId][0];

        document.getElementById("pageSubtitle")
            .textContent = titles[sectionId][1];

    }
}



// =====================================================
// HELPER
// =====================================================

function formatCurrency(value) {

    const number =
        Number(value || 0);

    return "₹" +
        number.toLocaleString(
            "en-IN",
            {
                maximumFractionDigits: 2
            }
        );
}



// =====================================================
// DASHBOARD
// =====================================================

async function loadDashboard() {

    try {

        const [

            zonesResponse,
            tanksResponse,
            growersResponse,
            vendorsResponse,
            telemetryResponse,
            heatResponse,
            profitLossResponse,
            budgetResponse

        ] = await Promise.all([

            fetch(`${API}/zones`),

            fetch(`${API}/tanks`),

            fetch(`${API}/growers`),

            fetch(`${API}/vendors`),

            fetch(`${API}/telemetry`),

            fetch(`${API}/net-heat`),

            fetch(`${API}/reports/profit-loss`),

            fetch(`${API}/reports/zone-budget`)

        ]);


        const zones =
            await zonesResponse.json();

        const tanks =
            await tanksResponse.json();

        const growers =
            await growersResponse.json();

        const vendors =
            await vendorsResponse.json();

        const telemetry =
            await telemetryResponse.json();

        const heatData =
            await heatResponse.json();

        const profitLoss =
            await profitLossResponse.json();

        const budget =
            await budgetResponse.json();



        // ==========================================
        // SUMMARY COUNTS
        // ==========================================

        document.getElementById("zoneCount")
            .textContent = zones.length;

        document.getElementById("tankCount")
            .textContent = tanks.length;

        document.getElementById("growerCount")
            .textContent = growers.length;

        document.getElementById("vendorCount")
            .textContent = vendors.length;



        // ==========================================
        // THERMAL
        // ==========================================

        const activeTanks =
            tanks.filter(
                tank =>
                    tank.status &&
                    tank.status.toUpperCase() === "ACTIVE"
            ).length;


        document.getElementById("activeTanks")
            .textContent = activeTanks;



        if (tanks.length > 0) {

            const validTemperatures =
                tanks
                    .map(tank =>
                        Number(
                            tank.currentWaterTemperature
                        )
                    )
                    .filter(temp =>
                        !isNaN(temp)
                    );


            if (validTemperatures.length > 0) {

                const average =
                    validTemperatures.reduce(
                        (sum, temp) =>
                            sum + temp,
                        0
                    ) /
                    validTemperatures.length;


                document.getElementById(
                    "avgTemperature"
                ).textContent =
                    average.toFixed(1);

            }

        }



        // ==========================================
        // NET HEAT
        // ==========================================

        let totalHeat = 0;


        heatData.forEach(item => {

            totalHeat +=
                Number(
                    item.netHeatKwh || 0
                );

        });


        document.getElementById("netHeat")
            .textContent =
            totalHeat.toFixed(2);



        // ==========================================
        // PROFIT & LOSS
        // ==========================================

        const totalIncome =
            Number(
                profitLoss.totalIncome || 0
            );

        const totalExpenses =
            Number(
                profitLoss.totalExpenses || 0
            );

        const profit =
            Number(
                profitLoss.profit || 0
            );


        document.getElementById("totalIncome")
            .textContent =
            formatCurrency(totalIncome);


        document.getElementById("totalExpenses")
            .textContent =
            formatCurrency(totalExpenses);


        document.getElementById("profit")
            .textContent =
            formatCurrency(profit);



        // ==========================================
        // ZONE DASHBOARD
        // ==========================================

        loadZoneDashboard(zones);



        // ==========================================
        // BUDGET
        // ==========================================

        loadBudgetSummary(budget);


    }

    catch (error) {

        console.error(
            "Dashboard loading error:",
            error
        );

    }

}



// =====================================================
// ZONE DASHBOARD
// =====================================================

function loadZoneDashboard(zones) {

    const container =
        document.getElementById(
            "zoneDashboard"
        );


    container.innerHTML = "";


    if (!zones || zones.length === 0) {

        container.innerHTML = `
            <div class="empty-state">
                No greenhouse zones available.
            </div>
        `;

        return;

    }


    zones.forEach(zone => {

        const card =
            document.createElement("div");


        card.className =
            "zone-mini-card";


        card.innerHTML = `

            <h4>
                🌿 ${zone.zoneName || "Zone"}
            </h4>

            <p>
                📍 ${zone.location || "Location not available"}
            </p>

            <p>
                ${zone.description || "No description"}
            </p>

        `;


        container.appendChild(card);

    });

}



// =====================================================
// BUDGET
// =====================================================

function loadBudgetSummary(budgets) {

    let planned = 0;

    let actual = 0;


    budgets.forEach(item => {

        planned +=
            Number(
                item.plannedExpense || 0
            );

        actual +=
            Number(
                item.actualAmount || 0
            );

    });


    document.getElementById(
        "plannedExpense"
    ).textContent =
        formatCurrency(planned);


    document.getElementById(
        "actualExpense"
    ).textContent =
        formatCurrency(actual);


    let percentage = 0;


    if (planned > 0) {

        percentage =
            (actual / planned) * 100;

    }


    document.getElementById(
        "budgetPercentage"
    ).textContent =
        percentage.toFixed(1) + "%";


    document.getElementById(
        "budgetProgress"
    ).style.width =
        Math.min(
            percentage,
            100
        ) + "%";

}



// =====================================================
// GREENHOUSE ZONES PAGE
// =====================================================
async function loadZones() {

    try {

        const response =
            await fetch("/api/zones");


        if (!response.ok) {

            throw new Error(
                "Could not load zones"
            );

        }


        const zones =
            await response.json();


        const container =
            document.getElementById(
                "zoneList"
            );


        if (!container) {
            return;
        }


        container.innerHTML = "";


        if (zones.length === 0) {

            container.innerHTML = `

                <div class="empty-state">

                    No greenhouse zones found.
                    Add your first zone above.

                </div>

            `;

            return;

        }


        zones.forEach(zone => {

            const card =
                document.createElement(
                    "div"
                );


            card.className =
                "record-card";


            card.innerHTML = `

                <span class="record-id">
                    ID: ${zone.id}
                </span>

                <h4>
                    🌿 ${zone.zoneName}
                </h4>

                <p>
                    📍 ${zone.location || "-"}
                </p>

                <p>
                    ${zone.description || "No description"}
                </p>

            `;


            container.appendChild(card);

        });

    }

    catch (error) {

        console.error(
            "Zone loading error:",
            error
        );

    }

}


// =====================================================
// START APPLICATION
// =====================================================

document.addEventListener(
    "DOMContentLoaded",
    () => {

        loadDashboard();

        loadZones();

    }
);